package nevermore.io.tbook.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nevermore.io.tbook.entity.Book;

/**
 * Created by Administrator on 2016/6/22.
 */
public class JSONParser {

    public static List<Book> parseBookList(JSONArray array) throws JSONException {
        List<Book> books = new ArrayList<Book>();
        for(int i=0; i<array.length(); i++){
            JSONObject object = array.getJSONObject(i);
            Book book = new Book();
            book.setId(object.getInt("id"));
            book.setAdd_time(object.getLong("add_time"));
            book.setDangPrice(object.getDouble("dangPrice"));
            book.setFixedPrice(object.getDouble("fixedPrice"));
            book.setHas_deleted(object.getInt("has_deleted"));
            book.setAdd_time(object.getLong("printTime"));
            book.setAdd_time(object.getLong("publishTime"));
            book.setAuthor(object.getString("author"));
            book.setCatalogue(object.getString("catalogue"));
            book.setDescription(object.getString("description"));
            book.setIsbn(object.getString("isbn"));
            book.setKeywords(object.getString("keywords"));
            book.setPrintNumber(object.getString("printNumber"));
            book.setProductName(object.getString("productName"));
            book.setProduct_pic(object.getString("product_pic"));
            book.setPublishedTime(object.getString("publishedTime"));
            book.setPublishing(object.getString("publishing"));
            book.setTotalPage(object.getString("totalPage"));
            book.setWhichEdtion(object.getString("whichEdtion"));
            book.setWordNumber(object.getString("wordNumber"));
            books.add(book);
        }
        return books;
    }
}
