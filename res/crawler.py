import re
import ssl
from urllib.request import urlopen

RESORT_INDEX = "/resortindex.xml"

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
        "name": name,
        "lat": float(coords[0]),
        "lng": float(coords[1])
    }

def crawl_ids(ids):
    with open("/Users/vlad/Desktop/resorts.txt", "w+", encoding="utf-8") as f:
        for id in ids:
            if id % 5 == 0:
                print(f"done upto {id}")
            try:
                res = read_resort(id)
            except IndexError as e:
                print(f"Failed to parse {id}. Skipping.")
            
            f.write(f"{id} {res['name']} {res['lat']} {res['lng']}\n")