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
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import za.co.svenlange.intellij.xtend.lexer.XtendLexer;
import za.co.svenlange.intellij.xtend.psi.XtendTypes;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;

/**
 * @author Sven Lange
 * @since 2013-03-22
 */
public class XtendSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

    static {
        fillMap(ATTRIBUTES, TokenSet.create(XtendTypes.COMMENT), DOC_COMMENT);
        fillMap(ATTRIBUTES, TokenSet.create(XtendTypes.STRING), STRING);
        fillMap(ATTRIBUTES, TokenSet.create(XtendTypes.KEYWORD), KEYWORD);
        fillMap(ATTRIBUTES, TokenSet.create(XtendTypes.INTEGERLITERAL), NUMBER);
//        fillMap(ATTRIBUTES, TokenSet.create(TokenType.BAD_CHARACTER), INVALID_STRING_ESCAPE);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new XtendLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }
}