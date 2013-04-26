package za.co.svenlange.intellij.xtend.components;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import org.jetbrains.annotations.NotNull;

/**
 * @author Sven Lange
 * @since 2013-04-26
 */
public class XtendProjectComponent implements ProjectComponent {

    public static final String XTEND_TRACEFILE_EXTENSION = ";*._trace;";

    @Override
    public void projectOpened() {
    }

    @Override
    public void projectClosed() {
    }

    @Override
    public void initComponent() {
        final String ignoredFilesList = FileTypeManager.getInstance().getIgnoredFilesList();
        if (!ignoredFilesList.contains(XTEND_TRACEFILE_EXTENSION)) {
            FileTypeManager.getInstance().setIgnoredFilesList(ignoredFilesList + XTEND_TRACEFILE_EXTENSION);
        }
    }

    @Override
    public void disposeComponent() {
    }

    @NotNull
    @Override
    public String getComponentName() {
        return getClass().getName();
    }
}
