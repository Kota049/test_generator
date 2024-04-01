package ValueObject;

import ValueObject.TargetType;

public class Assert {
    private final TargetType targetType;
    private final String target;

    public Assert(String targetType, String target) {
        // todo:validate
        this.targetType = TargetType.valueOf(targetType);
        this.target = target;
    }

    public String generateLine() {
        return this.targetType.getAssertion().replace("{content}", this.target);
    }
}