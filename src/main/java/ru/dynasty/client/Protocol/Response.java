package ru.dynasty.client.Protocol;

public class Response<T> {

    private Header header;
    private T data;

    public Response() {
        this.header = new Header();
    }

    public T getData() {
        return data;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setHeaderName(String name) {
        this.header.setName(name);
    }



    public String getHeaderName() { return this.header.getName(); }


    @Override
    public String toString() {
        return
                "{" +
                        "header: {" +
                        "\"name\"=\"" + getHeaderName() + "\", " +
                        "}" +
                        "data: " + getData() + "" +
                        "}";
    }

    public static <E> Response<E> build(E data) {
        Response response = new Response();
        response.setData(data);
        return response;
    }
}

class Header {

    private String name;

    public Header() {}

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


}
