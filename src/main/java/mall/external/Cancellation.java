package mall.external;

public class Cancellation {

    private Long id;
    private Long orderId;
    private String staus;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getStaus() {
        return staus;
    }
    public void setStaus(String staus) {
        this.staus = staus;
    }

}
