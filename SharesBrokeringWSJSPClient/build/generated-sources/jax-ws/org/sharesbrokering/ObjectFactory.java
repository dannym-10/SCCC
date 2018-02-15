
package org.sharesbrokering;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.sharesbrokering package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IOException_QNAME = new QName("http://SharesBrokering.org/", "IOException");
    private final static QName _ParseException_QNAME = new QName("http://SharesBrokering.org/", "ParseException");
    private final static QName _BuyShares_QNAME = new QName("http://SharesBrokering.org/", "buyShares");
    private final static QName _BuySharesResponse_QNAME = new QName("http://SharesBrokering.org/", "buySharesResponse");
    private final static QName _GetAvailableShares_QNAME = new QName("http://SharesBrokering.org/", "getAvailableShares");
    private final static QName _GetAvailableSharesResponse_QNAME = new QName("http://SharesBrokering.org/", "getAvailableSharesResponse");
    private final static QName _GetNewsOnline_QNAME = new QName("http://SharesBrokering.org/", "getNewsOnline");
    private final static QName _GetNewsOnlineResponse_QNAME = new QName("http://SharesBrokering.org/", "getNewsOnlineResponse");
    private final static QName _GetSharesOnline_QNAME = new QName("http://SharesBrokering.org/", "getSharesOnline");
    private final static QName _GetSharesOnlineResponse_QNAME = new QName("http://SharesBrokering.org/", "getSharesOnlineResponse");
    private final static QName _SearchSharePriceOrName_QNAME = new QName("http://SharesBrokering.org/", "searchSharePriceOrName");
    private final static QName _SearchSharePriceOrNameResponse_QNAME = new QName("http://SharesBrokering.org/", "searchSharePriceOrNameResponse");
    private final static QName _SellShare_QNAME = new QName("http://SharesBrokering.org/", "sellShare");
    private final static QName _SellShareResponse_QNAME = new QName("http://SharesBrokering.org/", "sellShareResponse");
    private final static QName _UnmarshalShares_QNAME = new QName("http://SharesBrokering.org/", "unmarshalShares");
    private final static QName _UnmarshalSharesResponse_QNAME = new QName("http://SharesBrokering.org/", "unmarshalSharesResponse");
    private final static QName _UpdateSharesRefresh_QNAME = new QName("http://SharesBrokering.org/", "updateSharesRefresh");
    private final static QName _UpdateSharesRefreshResponse_QNAME = new QName("http://SharesBrokering.org/", "updateSharesRefreshResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.sharesbrokering
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnmarshalSharesResponse }
     * 
     */
    public UnmarshalSharesResponse createUnmarshalSharesResponse() {
        return new UnmarshalSharesResponse();
    }

    /**
     * Create an instance of {@link GetSharesOnlineResponse }
     * 
     */
    public GetSharesOnlineResponse createGetSharesOnlineResponse() {
        return new GetSharesOnlineResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link Shares }
     * 
     */
    public Shares createShares() {
        return new Shares();
    }

    /**
     * Create an instance of {@link Share }
     * 
     */
    public Share createShare() {
        return new Share();
    }

    /**
     * Create an instance of {@link BuyShares }
     * 
     */
    public BuyShares createBuyShares() {
        return new BuyShares();
    }

    /**
     * Create an instance of {@link BuySharesResponse }
     * 
     */
    public BuySharesResponse createBuySharesResponse() {
        return new BuySharesResponse();
    }

    /**
     * Create an instance of {@link GetAvailableShares }
     * 
     */
    public GetAvailableShares createGetAvailableShares() {
        return new GetAvailableShares();
    }

    /**
     * Create an instance of {@link GetAvailableSharesResponse }
     * 
     */
    public GetAvailableSharesResponse createGetAvailableSharesResponse() {
        return new GetAvailableSharesResponse();
    }

    /**
     * Create an instance of {@link GetNewsOnline }
     * 
     */
    public GetNewsOnline createGetNewsOnline() {
        return new GetNewsOnline();
    }

    /**
     * Create an instance of {@link GetNewsOnlineResponse }
     * 
     */
    public GetNewsOnlineResponse createGetNewsOnlineResponse() {
        return new GetNewsOnlineResponse();
    }

    /**
     * Create an instance of {@link GetSharesOnline }
     * 
     */
    public GetSharesOnline createGetSharesOnline() {
        return new GetSharesOnline();
    }

    /**
     * Create an instance of {@link SearchSharePriceOrName }
     * 
     */
    public SearchSharePriceOrName createSearchSharePriceOrName() {
        return new SearchSharePriceOrName();
    }

    /**
     * Create an instance of {@link SearchSharePriceOrNameResponse }
     * 
     */
    public SearchSharePriceOrNameResponse createSearchSharePriceOrNameResponse() {
        return new SearchSharePriceOrNameResponse();
    }

    /**
     * Create an instance of {@link SellShare }
     * 
     */
    public SellShare createSellShare() {
        return new SellShare();
    }

    /**
     * Create an instance of {@link SellShareResponse }
     * 
     */
    public SellShareResponse createSellShareResponse() {
        return new SellShareResponse();
    }

    /**
     * Create an instance of {@link UnmarshalShares }
     * 
     */
    public UnmarshalShares createUnmarshalShares() {
        return new UnmarshalShares();
    }

    /**
     * Create an instance of {@link UpdateSharesRefresh }
     * 
     */
    public UpdateSharesRefresh createUpdateSharesRefresh() {
        return new UpdateSharesRefresh();
    }

    /**
     * Create an instance of {@link UpdateSharesRefreshResponse }
     * 
     */
    public UpdateSharesRefreshResponse createUpdateSharesRefreshResponse() {
        return new UpdateSharesRefreshResponse();
    }

    /**
     * Create an instance of {@link SharePrice }
     * 
     */
    public SharePrice createSharePrice() {
        return new SharePrice();
    }

    /**
     * Create an instance of {@link ShareInfo }
     * 
     */
    public ShareInfo createShareInfo() {
        return new ShareInfo();
    }

    /**
     * Create an instance of {@link UnmarshalSharesResponse.Return }
     * 
     */
    public UnmarshalSharesResponse.Return createUnmarshalSharesResponseReturn() {
        return new UnmarshalSharesResponse.Return();
    }

    /**
     * Create an instance of {@link GetSharesOnlineResponse.Return }
     * 
     */
    public GetSharesOnlineResponse.Return createGetSharesOnlineResponseReturn() {
        return new GetSharesOnlineResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "buyShares")
    public JAXBElement<BuyShares> createBuyShares(BuyShares value) {
        return new JAXBElement<BuyShares>(_BuyShares_QNAME, BuyShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuySharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "buySharesResponse")
    public JAXBElement<BuySharesResponse> createBuySharesResponse(BuySharesResponse value) {
        return new JAXBElement<BuySharesResponse>(_BuySharesResponse_QNAME, BuySharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "getAvailableShares")
    public JAXBElement<GetAvailableShares> createGetAvailableShares(GetAvailableShares value) {
        return new JAXBElement<GetAvailableShares>(_GetAvailableShares_QNAME, GetAvailableShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "getAvailableSharesResponse")
    public JAXBElement<GetAvailableSharesResponse> createGetAvailableSharesResponse(GetAvailableSharesResponse value) {
        return new JAXBElement<GetAvailableSharesResponse>(_GetAvailableSharesResponse_QNAME, GetAvailableSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewsOnline }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "getNewsOnline")
    public JAXBElement<GetNewsOnline> createGetNewsOnline(GetNewsOnline value) {
        return new JAXBElement<GetNewsOnline>(_GetNewsOnline_QNAME, GetNewsOnline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewsOnlineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "getNewsOnlineResponse")
    public JAXBElement<GetNewsOnlineResponse> createGetNewsOnlineResponse(GetNewsOnlineResponse value) {
        return new JAXBElement<GetNewsOnlineResponse>(_GetNewsOnlineResponse_QNAME, GetNewsOnlineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSharesOnline }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "getSharesOnline")
    public JAXBElement<GetSharesOnline> createGetSharesOnline(GetSharesOnline value) {
        return new JAXBElement<GetSharesOnline>(_GetSharesOnline_QNAME, GetSharesOnline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSharesOnlineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "getSharesOnlineResponse")
    public JAXBElement<GetSharesOnlineResponse> createGetSharesOnlineResponse(GetSharesOnlineResponse value) {
        return new JAXBElement<GetSharesOnlineResponse>(_GetSharesOnlineResponse_QNAME, GetSharesOnlineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchSharePriceOrName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "searchSharePriceOrName")
    public JAXBElement<SearchSharePriceOrName> createSearchSharePriceOrName(SearchSharePriceOrName value) {
        return new JAXBElement<SearchSharePriceOrName>(_SearchSharePriceOrName_QNAME, SearchSharePriceOrName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchSharePriceOrNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "searchSharePriceOrNameResponse")
    public JAXBElement<SearchSharePriceOrNameResponse> createSearchSharePriceOrNameResponse(SearchSharePriceOrNameResponse value) {
        return new JAXBElement<SearchSharePriceOrNameResponse>(_SearchSharePriceOrNameResponse_QNAME, SearchSharePriceOrNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SellShare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "sellShare")
    public JAXBElement<SellShare> createSellShare(SellShare value) {
        return new JAXBElement<SellShare>(_SellShare_QNAME, SellShare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SellShareResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "sellShareResponse")
    public JAXBElement<SellShareResponse> createSellShareResponse(SellShareResponse value) {
        return new JAXBElement<SellShareResponse>(_SellShareResponse_QNAME, SellShareResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnmarshalShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "unmarshalShares")
    public JAXBElement<UnmarshalShares> createUnmarshalShares(UnmarshalShares value) {
        return new JAXBElement<UnmarshalShares>(_UnmarshalShares_QNAME, UnmarshalShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnmarshalSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "unmarshalSharesResponse")
    public JAXBElement<UnmarshalSharesResponse> createUnmarshalSharesResponse(UnmarshalSharesResponse value) {
        return new JAXBElement<UnmarshalSharesResponse>(_UnmarshalSharesResponse_QNAME, UnmarshalSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSharesRefresh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "updateSharesRefresh")
    public JAXBElement<UpdateSharesRefresh> createUpdateSharesRefresh(UpdateSharesRefresh value) {
        return new JAXBElement<UpdateSharesRefresh>(_UpdateSharesRefresh_QNAME, UpdateSharesRefresh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSharesRefreshResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SharesBrokering.org/", name = "updateSharesRefreshResponse")
    public JAXBElement<UpdateSharesRefreshResponse> createUpdateSharesRefreshResponse(UpdateSharesRefreshResponse value) {
        return new JAXBElement<UpdateSharesRefreshResponse>(_UpdateSharesRefreshResponse_QNAME, UpdateSharesRefreshResponse.class, null, value);
    }

}
