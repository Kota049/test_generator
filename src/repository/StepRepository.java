package repository;

import entity.Step;

import java.util.ArrayList;
import java.util.List;

public interface StepRepository {
    // csvファイルを読み込んで、全部取得する
    List<Step> fetchAllSteps() throws Exception;

    void save() throws Exception;
}