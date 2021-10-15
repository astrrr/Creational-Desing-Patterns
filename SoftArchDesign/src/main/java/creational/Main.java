package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException {

        // Current usage
//        BookMetadataFormatter formatter = null;
//        try {
//            formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.CSV);
//            formatter.append(TestData.dragonBook);
//            formatter.append(TestData.dinosaurBook);
//            System.out.print(formatter.getMetadataString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }

        // Expected usage
        BookMetadataExporter exporter = new XMLBookMetadataExporter();
        exporter.add(TestData.sailboatBook);
        exporter.add(TestData.GoFBook);
        exporter.export(System.out);

        BookMetadataExporter exporter1 = new CSVBookMetadataExporter();
        exporter1.add(TestData.dragonBook);
        exporter1.export(System.out);

        BookMetadataExporter exporter2 = new JSONBookMetadataExporter();
        exporter2.add(TestData.dinosaurBook);
        exporter2.export(System.out);
    }
}
