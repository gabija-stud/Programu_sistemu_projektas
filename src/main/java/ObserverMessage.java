public class ObserverMessage implements Observer {
    private String customer;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public void update() {
        System.out.println("Game Over");
    }
}
