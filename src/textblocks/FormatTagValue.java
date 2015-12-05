package textblocks;

import util.Tuple;

import java.util.*;

/**
 * Class for associating {@link FormatTag}s with a value.
 *
 * Created by justusadam on 05/12/15.
 */
public abstract class FormatTagValue {

    private FormatTag formatTag;

    public FormatTagValue () {}

    protected FormatTagValue(FormatTag tag) {
        formatTag = tag;
    }

    public String getName() {
        return formatTag.getName();
    }

    public String asInput(String identifier) {
        return formatTag.asInput(identifier);
    }

    public String asIdentifier(String baseIdentifier) {
        return formatTag.asIdentifier(baseIdentifier);
    }

    protected abstract FormatTagValue fromValue(FormatTag tag, String s) throws TypeError;

    /**
     * This is the canonical function for constructing a {@link FormatTagValue} from the {@link String} out of a html
     * form
     *
     * It verifies the input and either throws a type error or constructs the value.
     *
     * @param tag tag to associate the constructed value with
     * @param value the string from the form
     * @return new FormatTagValue
     * @throws TypeError
     */
    public final FormatTagValue fromForm(FormatTag tag, String value) throws TypeError {
        if (verify(value))
            return fromValue(tag, value);
        else
            throw new TypeError();
    }

    /**
     * Verifies the structure of the input.
     *
     * This should be overwritten in subclasses if the input needs a specific structure.
     *
     * @param value String from the html form
     * @return true if the structure is correct
     */
    public boolean verify(String value) {
        return true;
    }

    /**
     * Constructs a String representation of the stored value.
     *
     * @return value as string
     */
    public abstract String valueRepresentation();

    /**
     * Two strings which are the appropriate html input element for this type.
     *
     * @return Tuple(delimiter 1, delimiter 2)
     */
    public abstract Tuple<String, String> inputDelims();

    public abstract List<String> getInputClasses();
}