import textblocks.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        long id = 123456;
        List<FormatTag> l = new ArrayList<>();
        l.add(new FormatTag(new MessageFormatTagValue(), "message"));
        l.add(new FormatTag(new TextFormatTagValue(), "name"));
        TextBlock block = new TextBlock(id, "Message: ${message} \n Name: ${name}", l);

        Map<String, String> requestValues = new HashMap<>();

        requestValues.put(id + "-name", "Jonny");
        requestValues.put(id + "-message", "Go there");

        TextBlockValue val = block.fromForm(requestValues);

        System.out.println(block);
        System.out.println(block.asForm());
        System.out.println(val);
    }
}
