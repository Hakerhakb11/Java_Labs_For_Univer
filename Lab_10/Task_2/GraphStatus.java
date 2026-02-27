package Lab_10.Task_2;

public enum GraphStatus {
    NON_VISITED(0),
    VISITED(1),
    COMPLETED(2);

    private int status;

    GraphStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
