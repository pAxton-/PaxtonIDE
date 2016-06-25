package pax.view;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * EditorFile extends RSyntaxTextArea
 * @see <a href="http://www.fifesoft.com/#/">fifesoft.com</a>
 * @author pAxton
 */
public class EditorFile extends RSyntaxTextArea {

    public EditorFile() {
        super();
        setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT);
        ;
        setCodeFoldingEnabled(true);
        setEditable(true);

    }
}
