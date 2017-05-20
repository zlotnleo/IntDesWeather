package uk.ac.cam.intdes.gr1.api;

import uk.ac.cam.intdes.gr1.api.xml.IterativeXMLParser;
import uk.ac.cam.intdes.gr1.api.xml.XMLObject;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SkiMapApi {
    private static final String API_URL = "https://skimap.org/SkiAreas/view/";

    private API api;

    public SkiMapApi() {
        api = new API(API_URL);
    }

    XMLObject inputStreamToXml(InputStream is) {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        IterativeXMLParser.registerReader(br);

        return IterativeXMLParser.parse();
    }

    public void create_db() {
        ArrayList<Integer> ids = new ArrayList<>();

        File file;
        try {
            file = new File("/Users/vlad/Desktop/resortids.out");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                ids.add(scanner.nextInt());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int cnt = 0;
        for (int id: ids) {
            api.startNewRequest();
            try {
                XMLObject res = api.manualExecute(API_URL + String.valueOf(id) + ".xml");
                System.out.println(res.getChildOfTag("skiArea").getChildOfTag("georeferencing").getData());
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (cnt++ > 5) {
                break;
            }
        }
    }
}
