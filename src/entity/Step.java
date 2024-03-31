package entity;

import ValueObject.StepId;
import ValueObject.Action;
import ValueObject.Assert;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private final StepId id;
    private final List<Action> actions;
    private final List<Assert> asserts;

    public Step(StepId id) {
        this.id = id;
        // todo: get from args;
        this.actions = new ArrayList<>();
        this.asserts = new ArrayList<>();
    }
}