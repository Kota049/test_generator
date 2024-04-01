package entity;

import ValueObject.StepId;
import ValueObject.Action;
import ValueObject.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Step {
    private final StepId id;
    private final StepId premiseId;
    private final String name;
    private final List<Action> actions;
    private final List<Assert> asserts;

    public Step(int id, int premiseId, String name) throws Exception {
        try {
            this.id = new StepId(id);
        } catch (Exception e) {
            throw e;
        }
        StepId validPremiseId = null;
        try {
            validPremiseId = new StepId(premiseId);
        } catch (Exception e) {
        } finally {
            this.premiseId = validPremiseId;
        }
        this.name = name;
        // todo: get from args;
        this.actions = new ArrayList<>();
        this.asserts = new ArrayList<>();
    }

    public String generateActions() {
        return this.actions
                .stream()
                .map(action -> "  " + action.gererateLine())
                .collect(Collectors.joining("\n"));
    }

    public String gerenateAssertion() {
        return this.actions
                .stream()
                .map(action -> "  " + action.gererateLine())
                .collect(Collectors.joining("\n"));
    }

    public String generateFirstRow() {
        return String.format("test(\'%s\', async ({ page }) => {\n", this.name);
    }

    public String generateLastRow() {
        return "}\n";
    }

    public StepId getPremiseId() {
        return premiseId;
    }
}