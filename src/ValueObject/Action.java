package ValueObject;

import ValueObject.TargetType;

public class Action {
    private final String actionContent;
    private final TargetType targetType;
    private final String target;

    public Action(String actionContent, String targetType, String target) {
        // todo:validate
        this.actionContent = actionContent;
        this.targetType = TargetType.valueOf(targetType);
        this.target = target;
    }

    public String gererateLine() {
        final String locator = this.targetType.getTemplate().replace("{content}", this.target);
        return String.format("await %s.%s ;", locator, actionContent);
    }
}