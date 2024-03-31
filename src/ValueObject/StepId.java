package ValueObject;
interface Id {
    int getId();
}
public class StepId implements Id {
    private final int value;

    public StepId(int value) {
        if (Objects.isNull(value)){
            throw new Exception("invalid id error");
        }
        this.value = value;
    }
    @Override
    public int getId() {
        return this.value;
    }
    public Boolean equals(StepId other) {
        return this.value == other.getId();
    }
}