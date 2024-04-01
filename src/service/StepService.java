package service;

import entity.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.Objects;
import java.util.stream.Collectors;

import repository.StepRepository;

public class StepService {
    private final StepRepository repo;

    public StepService(StepRepository repo) {
        this.repo = repo;
    }

    static String generateActions(List<Step> steps, Step step) {
        String res = step.generateActions();
        if (Objects.isNull(step.getPremiseId())) {
            return res;
        }
        Step premise = steps.stream().filter(s -> s.getPremiseId() == step.getPremiseId()).findFirst().orElse(null);
        if (Objects.isNull(premise)) {
            return res;
        }
        return generateActions(steps, premise) + res;
    }
    public static List<String> generateStatements(List<Step> steps) {
        return steps.stream().map(st -> st.generateFirstRow() + generateActions(steps, st) + st.gerenateAssertion() + st.generateLastRow()).collect(Collectors.toList());
    }
}