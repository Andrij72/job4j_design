package io.cd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class describe emulation of linux commands
 */
public class Shell {
    private String currentCursor = "/";
    List<String> arrayList = new LinkedList<>();

    public void cd(String path) {
        arrayList.clear();
        arrayList.add("/");
        if (path.equals("/")) {
            currentCursor = arrayList.get(0);
        } else if (path.startsWith("/")) {
            String[] str = path.substring(1).split("/");
            arrayList.addAll(Arrays.asList(str));
            currentCursor = String.join("/", arrayList).substring(1);
        } else if (path.equals("..") || path.startsWith("../")) {
            currentCursor = arrayList.get(arrayList.size() - 1);
        } else {
            String[] str = path.split("/");
            arrayList.addAll(Arrays.asList(str));
            String st = String.join("", arrayList);
            if (!currentCursor.equals("/")) {
                currentCursor = currentCursor.substring(1);
            }
            currentCursor = currentCursor.concat(st);
        }
    }

    public String pwd() {
        return currentCursor;
    }
}
