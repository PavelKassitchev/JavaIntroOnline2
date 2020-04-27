package by.pavka.task.task1;

import com.sun.jndi.toolkit.url.Uri;

public class ERepo implements Locatable {

    private Uri uri;

    public ERepo(Uri uri) {
        this.uri = uri;
    }

    @Override
    public String getLocation() {
        return uri.getPath();
    }
}
