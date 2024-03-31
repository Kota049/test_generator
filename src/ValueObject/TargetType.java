package ValueObject;

interface TargetTypeInterface {
    String template();
}

public enum TargetType implements TargetTypeInterface {
    TEST_ID {
        @Override
        public String template() {
            return "page.getByTestId(\'{{content}}\')";
        };

    },
    LABEL {
        @Override
        public String template() {
            return "page.getByLabel(\'{{content}}\')";
        };
    },
    BUTTON{
        @Override
        public String template(){
            return "page.getByRole(\'button\', { name: \'{{content}}\' })";
        };
    },
    TEXT{
        @Override
        public String template(){
            return "page.getByRole(\'{content}\', { extract: true })";
        };
    };
    public String getTemplate(){
        return this.template();
    }
}
