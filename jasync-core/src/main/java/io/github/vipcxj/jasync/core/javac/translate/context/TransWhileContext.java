package io.github.vipcxj.jasync.core.javac.translate.context;

import com.sun.tools.javac.tree.JCTree;
import io.github.vipcxj.jasync.core.javac.context.AnalyzerContext;
import io.github.vipcxj.jasync.core.javac.context.JAsyncSymbols;
import io.github.vipcxj.jasync.core.javac.translate.TranslateContext;

public class TransWhileContext extends TransWhileLikeContext<JCTree.JCWhileLoop> {

    public TransWhileContext(AnalyzerContext analyzerContext, JCTree.JCWhileLoop tree) {
        super(analyzerContext, tree);
        this.childState = tree.cond != null
                ? ChildState.COND
                : tree.body != null
                ? ChildState.BODY
                : ChildState.COMPLETE;
    }

    @Override
    public TransWhileContext enter() {
        super.enter();
        return this;
    }

    @Override
    protected void addNormalChildContext(TranslateContext<?> child) {
        if (childState == ChildState.COND) {
            addCond(child);
            childState = tree.body != null
                    ? ChildState.BODY
                    : ChildState.COMPLETE;
        } else if (childState == ChildState.BODY) {
            addBody(child);
            childState = ChildState.COMPLETE;
        } else {
            throwIfFull();
        }
    }

    @Override
    protected JCTree.JCExpression getBuildMethod() {
        JAsyncSymbols symbols = analyzerContext.getJasyncContext().getJAsyncSymbols();
        return hasAwaitCond() ? symbols.makeJAsyncDoPromiseWhile() : symbols.makeJAsyncDoWhile();
    }

    @Override
    protected void setCondTree(JCTree.JCExpression condTree) {
        tree.cond = condTree;
    }

    @Override
    protected void setBodyTree(JCTree.JCStatement bodyTree) {
        tree.body = bodyTree;
    }
}
