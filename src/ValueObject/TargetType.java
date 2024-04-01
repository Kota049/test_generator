package ValueObject;

interface TargetTypeInterface {
    String template();
}

public enum TargetType implements TargetTypeInterface {
    TEST_ID {
        @Override
        public String template() {
            return "page.getByTestId(\'{{content}}\')";
        }
    },
    LABEL {
        @Override
        public String template() {
            return "page.getByLabel(\'{{content}}\')";
        }
    },
    BUTTON {
        @Override
        public String template() {
            return "page.getByRole(\'button\', { name: \'{{content}}\' })";
        }
    },
    TEXT {
        @Override
        public String template() {
            return "page.getByRole(\'{content}\', { extract: true })";
        }
    },
    URL {
        @Override
        public String template() {
            return "page.goto(\'{content}\')";
        }
    };

    public String getTemplate() {
        return this.template();
    }

    public String getAssertion() {
        if (this == TargetType.URL) {
            return String.format("await expect(page.url()).toHaveText(\'{content}\')");
        }
        return String.format("await expect(%s).toBeVisible()", this.getTemplate());
    }
}
