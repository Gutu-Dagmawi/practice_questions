package grades;

public class Validator {

    public static boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }

    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        // only letters, spaces, dots and dashes allowed
        return name.trim().matches("[a-zA-Z .'-]+");
    }

    public static boolean isValidId(String id) {
        if (id == null) {
            return false;
        }
        // e.g. UGR/1234/16 or just 1234 -- dont want to be too strict
        return id.trim().matches("[A-Za-z0-9/-]{1,20}");
    }

    // returns -1 if the text is not a valid mark
    public static double parseMark(String text) {
        if (text == null) {
            return -1;
        }
        try {
            double mark = Double.parseDouble(text.trim());
            if (isValidMark(mark)) {
                return mark;
            }
        } catch (NumberFormatException e) {
            // fall through
        }
        return -1;
    }

    public static int parsePositiveInt(String text, int max) {
        if (text == null) {
            return -1;
        }
        try {
            int n = Integer.parseInt(text.trim());
            if (n >= 1 && n <= max) {
                return n;
            }
        } catch (NumberFormatException e) {
        }
        return -1;
    }
}
