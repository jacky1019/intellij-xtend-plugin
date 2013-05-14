/*
 * Copyright 2013 Sven Lange
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.co.svenlange.intellij.xtend;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import za.co.svenlange.intellij.xtend.lexer.XtendLexer;
import za.co.svenlange.intellij.xtend.psi.XtendTypes;

import java.awt.*;
import java.io.Reader;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author Sven Lange
 * @since 2013-03-22
 */
public class XtendSyntaxHighlighter extends SyntaxHighlighterBase {
    
    static final TextAttributesKey COMMENT = createTextAttributesKey("COMMENT", new TextAttributes(new Color(63, 127, 95), null, null, null, Font.PLAIN));
    static final TextAttributesKey STRING = createTextAttributesKey("STRING", new TextAttributes(new Color(42, 0, 255), null, null, null, Font.PLAIN));
    static final TextAttributesKey INTEGERLITERAL = createTextAttributesKey("INTEGERLITERAL", new TextAttributes(new Color(125, 125, 125), null, null, null, Font.PLAIN));
    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", new TextAttributes(Color.RED, null, null, null, Font.BOLD));
    static final TextAttributesKey KEYWORD = createTextAttributesKey("KEYWORD", new TextAttributes(new Color(127, 0, 85), null, null, null, Font.BOLD));

    private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] INTEGERLITERAL_KEYS = new TextAttributesKey[]{INTEGERLITERAL};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new XtendLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(XtendTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHARACTER_KEYS;
        } else if (tokenType.equals(XtendTypes.KEYWORD)) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(XtendTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(XtendTypes.INTEGERLITERAL)) {
            return INTEGERLITERAL_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}