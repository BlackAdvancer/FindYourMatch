package yuheng.personal.findyourmatch.providers;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Abstract Http data provider
 */
public abstract class AbstractHttpDataProvider implements DataProvider{
    protected HttpURLConnection conn;

    public AbstractHttpDataProvider() {
        conn = null;
    }

    @Override
    public String dataSourceToString() throws IOException {
        //TODO: Error message needs to be handled.
        final int CONNECT_TIMEOUT = 2000;  // timeout in ms
        final int READ_TIMEOUT = 3000;     // timeout in ms
        final int HTTP_OK = 200;           // HTTP success code
        StringBuilder jsonResults = new StringBuilder();

        URL url = getURL();

        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setRequestProperty("Accept", "application/JSON");
            conn.setReadTimeout(READ_TIMEOUT);
            conn.connect();
            int response = conn.getResponseCode();
            if (response != HTTP_OK) {
                //TODO: Error response code needs to be handled.
                throw new IOException("HTTP response code:" + response + "- failed to obtain data");
            }

            jsonResults = readResponse();
        } catch (Exception e) {
            jsonResults.append(e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return jsonResults.toString();
    }

    /**
     * read response and convert it to JSON string
     *
     * @return Response JSON string.
     * @throws IOException when error occur during the reading.
     */
    private StringBuilder readResponse() throws IOException {
        StringBuilder jsonResults = new StringBuilder();
        InputStreamReader in = new InputStreamReader(conn.getInputStream());

        // Load the results into a StringBuilder
        int read;
        char[] buff = new char[1024];
        while((read = in.read(buff)) != -1) {
            jsonResults.append(buff, 0, read);
        }

        return jsonResults;
    }

    /**
     * Get URL of Http data provider
     *
     * @return  URL of http data provider
     * @throws MalformedURLException  when URL is malformed
     */
    protected abstract URL getURL() throws MalformedURLException;
}