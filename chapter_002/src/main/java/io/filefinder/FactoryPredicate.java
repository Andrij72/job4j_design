package io.filefinder;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FactoryPredicate {

    Predicate<Path> conditionSet(Parameters params) {
        Predicate<Path> option = p -> true;

        switch (params.getSearchType().toLowerCase()) {
            case "name":
                return new FinderConditions(params.getExtKey());
            case "mask":
                return new FinderConditions(this.getMask(params.getExtKey()));
            default:
                throw new IllegalStateException("Unexpected value: " + params.getSearchType().toLowerCase());
        }
    }

    public class FinderConditions implements Predicate<Path> {

        private final Pattern pattern;

        public FinderConditions(String condition) {
            this.pattern = Pattern.compile(condition);
        }

        @Override
        public boolean test(Path path) {
            return pattern.matcher(path.toFile().getName()).matches();
        }
    }

    private static String getMask(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char el = str.charAt(i);
            if (el == '.') {
                sb.append("\\.");
            } else if (el == '*') {
                sb.append(".*");
            } else {
                sb.append(el);
            }
        }
        return sb.toString();
    }

}
