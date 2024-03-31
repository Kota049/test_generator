package repository;

interface StepRepository {
    // csvファイルを読み込んで、全部取得する
    List<Step> fetchAllSteps() throws Exception {
    }

    ;

    void save() throws Exception {
    }

    ;
}