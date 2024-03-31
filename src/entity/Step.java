package entity;

import ValueObject.StepId;
import ValueObject.Action;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private final StepId id;
    private final List<Action> actions;

    public Step(StepId id) {
        this.id = id;
        // todo: get from args;
        this.actions = new ArrayList<>();
    }
}