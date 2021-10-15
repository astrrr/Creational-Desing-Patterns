package creational;


import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;


public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private JSONObject jsonObject;
    private JSONArray jsonArray;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        jsonObject = new JSONObject();
        jsonArray = new JSONArray();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.

        JSONObject book = new JSONObject();

        book.put("ISBN", b.getISBN());
        book.put("Title", b.getTitle());
        book.put("Publisher", b.getPublisher());


        JSONArray arrayAuthor = new JSONArray();
        for (String author : b.getAuthors()) {
            arrayAuthor.add(author);
        }
        book.put("Authors", arrayAuthor);


        jsonArray.add(book);

        jsonObject.put("Books", jsonArray);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return jsonObject.toJSONString();
    }
}
