package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    public void export(PrintStream stream) {}

    @Override
    public void add(Book b) {
        super.add(b);
    }
}

class XMLBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter xmlBookMetadataFormatter = new XMLBookMetadataFormatter();

    XMLBookMetadataExporter() throws ParserConfigurationException {
    }

    @Override
    public void export(PrintStream stream) {

        stream.println(xmlBookMetadataFormatter.getMetadataString());
    }

    @Override
    public void add(Book b) {
        xmlBookMetadataFormatter.append(b);
    }
}

class CSVBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter csvBookMetadataFormatter = new CSVBookMetadataFormatter();

    CSVBookMetadataExporter() throws IOException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println(csvBookMetadataFormatter.getMetadataString());
    }

    @Override
    public void add(Book b) {
        csvBookMetadataFormatter.append(b);
    }
}

class JSONBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter jsonBookMetadataFormatter = new JSONBookMetadataFormatter();

    JSONBookMetadataExporter() throws IOException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println(jsonBookMetadataFormatter.getMetadataString());
    }

    @Override
    public void add(Book b) {
        jsonBookMetadataFormatter.append(b);
    }
}