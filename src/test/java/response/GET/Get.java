package response.GET;

import java.util.List;

public class Get {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private Support support;


    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<Data> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public static class Support {
        private String url;
        private String text;

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }
    }
}