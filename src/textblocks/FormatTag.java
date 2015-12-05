package textblocks;

import util.Tuple;


public final class FormatTag {
    private FormatTagValue value;
    private String name;

    public FormatTag(FormatTagValue value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FormatTagValue toValue(String s) throws TypeError {
        return value.fromForm(this, s);
    }

    public String asInput(String identifier) {
        String myIdentifier = asIdentifier(identifier);
        Tuple<String, String> delims = value.inputDelims();

        return delims.get1() + "name=\"" +
                myIdentifier +
                '-' +
                name +
                "\" " +
                "class=\"" +
                value.getInputClasses().stream().reduce(String::concat).orElse("") +
                "\" " +
                delims.get2();
    }

    public String asIdentifier(String baseIdentifier) {
        return baseIdentifier + "-" + name;
    }
}
