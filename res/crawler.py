import re
import ssl
from urllib.request import urlopen

RESORT_INDEX = "/Users/vlad/Desktop/resortindex.xml"
RESORTS = "/Users/vlad/Desktop/resorts.txt"
RESORTS_FIX = "/Users/vlad/Desktop/resorts_fix.txt"

def read_ids(filepath):
    with open(filepath, "r", encoding="utf-8") as f:
        ids = re.findall(r'<skiArea id="(\d+)">', f.read())
        ids = [int(id) for id in ids]
        return ids

# evil context(oh, well...)
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

RESORT_URL_BASE = "http://skimap.org/SkiAreas/view/"

def read_resort(id):
    f = urlopen(RESORT_URL_BASE + str(id) + ".xml", context=ctx)
    s = f.read()
    name = re.findall(b'<name>\s*<!\[CDATA\[(.*)]]>\s*</name>', s)[0]
    coords = re.findall(b'lat="(-?\d*.?\d*)"\s+lng="(-?\d*.?\d*)"', s)[0]
    return {
        "id": id,
        "name": name.decode(),
        "lat": float(coords[0]),
        "lng": float(coords[1])
    }

def crawl_ids(ids):
    with open(RESORTS, "w+", encoding="utf-8") as f:
        for id in ids:
            if id % 5 == 0:
                print(f"done upto {id}")
            try:
                res = read_resort(id)
            except IndexError as e:
                print(f"Failed to parse {id}. Skipping.")

            f.write(f"{id} {res['name']} {res['lat']} {res['lng']}\n")

def decode_bytes():
    resorts = []
    with open(RESORTS, "r") as f:
        for line in f:
            try:
                resort = line.encode('latin-1').decode('unicode_escape')
                resort = bytes(resort, 'latin-1').decode('utf-8')
                resort = re.sub(r"b'(.*)'", lambda m: '{' + m.groups()[0] + '}', resort)
                resort = re.sub(r'b"(.*)"', lambda m: '{' + m.groups()[0] + '}', resort)
                resorts.append(resort)
            except UnicodeEncodeError as e:
                print(line)

    names = {}
    def duplicate(r):
        name = re.findall(r"{(.*)}", r)[0]
        res = name in names
        names[name] = r
        return res

    resorts.sort(key=lambda s: int(s.split()[0]))
    resorts = [r for r in resorts if not duplicate(r)]

    with open(RESORTS_FIX, "w+", encoding='utf-8') as f:
        for resort in resorts:
            f.write(resort)
