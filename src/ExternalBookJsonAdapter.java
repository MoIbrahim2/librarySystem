public class ExternalBookJsonAdapter {
    public Book adapt(String json) {
        String title = extractString(json, "bookTitle");
        boolean isBorrowable = extractBoolean(json, "isBorrowable");
        String authorName = extractString(json, "authorName");
        int year = extractInt(json, "year");

        return new Book(title, isBorrowable, authorName, year);
    }

    private String extractString(String json, String fieldName) {
        String key = "\"" + fieldName + "\"";
        int keyIndex = json.indexOf(key);
        int colonIndex = json.indexOf(':', keyIndex);
        int startQuoteIndex = json.indexOf('"', colonIndex + 1);
        int endQuoteIndex = json.indexOf('"', startQuoteIndex + 1);
        return json.substring(startQuoteIndex + 1, endQuoteIndex);
    }

    private boolean extractBoolean(String json, String fieldName) {
        String value = extractRawValue(json, fieldName);
        return Boolean.parseBoolean(value);
    }

    private int extractInt(String json, String fieldName) {
        String value = extractRawValue(json, fieldName);
        return Integer.parseInt(value);
    }

    private String extractRawValue(String json, String fieldName) {
        String key = "\"" + fieldName + "\"";
        int keyIndex = json.indexOf(key);
        int colonIndex = json.indexOf(':', keyIndex);
        int valueStart = colonIndex + 1;

        while (valueStart < json.length() && Character.isWhitespace(json.charAt(valueStart))) {
            valueStart++;
        }

        int valueEnd = valueStart;
        while (valueEnd < json.length() && json.charAt(valueEnd) != ',' && json.charAt(valueEnd) != '}') {
            valueEnd++;
        }

        return json.substring(valueStart, valueEnd).trim();
    }
}
