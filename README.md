# Xtend language plugin for IntelliJ Idea

The IntelliJ Xtend language plugin brings superb [Xtend](http://xtend-lang.org) IDE support to IntelliJ IDEA.

## Releases

None so far. This plugin is still experimental and under development. The first public release is still to come.

## Project Links

SCM https://github.com/svenlange/intellij-xtend-plugin

## Development Setup
1. Download IntelliJ Community Edition (idea-IC)
2. Checkout this git repository
3. Start idea-IC and open the file <code>xtend-intellij.ipr</code>
4. Define the <code>Project SDK</code> by clicking <code>File > Project Structure...</code> in the main menu
5. Click <code>New...</code> and choose <code>Intellij Platform Plugin SDK</code> under <code>Project</code> in the <code>Project Settings</code>
 5. A wizard will help to setup the JDK and Plugin SDK. Choose a Java 6 JDK and pick the installed idea-IC as Plugin SDK
6. To build the plugin click <code>Build > Prepare Plugin Module 'xtend-intellij' For Deployment</code> in the main menu
7. For the plugin development install the plugins [JFlex](http://plugins.intellij.net/plugin/?idea&pluginId=263) and [Grammar-Kit](http://plugins.intellij.net/plugin?pr=idea&pluginId=6606)

## Resources

### Intellij Plugin Development

* [Custom Language Support Tutorial](http://confluence.jetbrains.com/display/IntelliJIDEA/Custom+Language+Support)
* http://confluence.jetbrains.net/display/IDEADEV/PluginDevelopment
* http://confluence.jetbrains.net/display/IDEADEV/Developing+Custom+Language+Plugins+for+IntelliJ+IDEA
* [IntelliJ IDEA Plugins - Custom Languages](http://plugins.intellij.net/category/index?pr=idea&category_id=48)
* https://github.com/mtoader/google-go-lang-idea-plugin
* [YouTube: Writing IntelliJ IDEA Plugins. Part I](http://www.youtube.com/watch?v=AktCFxC9Bx0)
* [JetBrains TV: Live Coding an IntelliJ IDEA Plugin from Scratch. Part 1](http://tv.jetbrains.net/videocontent/live-coding-an-intellij-idea-plugin-from-scratch)
* [JetBrains TV: Live Coding an IntelliJ IDEA Plugin from Scratch. Part 2](http://tv.jetbrains.net/videocontent/live-coding-an-intellij-idea-plugin-from-scratch-part-2)
* Lexer (JFlex)
  * http://jflex.de/manual.html
  * http://james.bond.edu.au/courses/inft13310/053/Slides/langs_lexing.html
  * http://james.bond.edu.au/courses/inft13310/053/Labs/jflex.html
* Parser
  * [Grammar-Kit](http://plugins.intellij.net/plugin?pr=idea&pluginId=6606&showAllUpdates=true)
  * [Grammar-Kit Forum Thread](http://devnet.jetbrains.net/thread/432304)
  * [Parsing Expression Grammars](http://bford.info/pub/lang/peg)
  * http://pegjs.majda.cz/online
  * http://www.cforcoding.com/2010/01/markdown-and-introduction-to-parsing.html
  * [grammar kit based ice framework plugin](http://code.google.com/p/ice-framework-idea-plugin/)

### Xtend

* [Eclipse Git - Xtend Xtext Grammar] (http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtend.core/src/org/eclipse/xtend/core/Xtend.xtext)
