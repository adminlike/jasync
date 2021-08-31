package io.github.vipcxj.jasync.core.javac.translate.context;

import com.sun.tools.javac.tree.JCTree;
import io.github.vipcxj.jasync.core.javac.context.AnalyzerContext;
import io.github.vipcxj.jasync.core.javac.model.Frame;
import io.github.vipcxj.jasync.core.javac.translate.TransFrameHolderContext;

public class AbstractTransFrameHolderExpressionContext<T extends JCTree.JCExpression>
        extends AbstractTransExpressionContext<T>
        implements TransFrameHolderContext<T> {

    private Frame frame;

    public AbstractTransFrameHolderExpressionContext(AnalyzerContext analyzerContext, T tree) {
        super(analyzerContext, tree);
    }

    @Override
    public Frame getFrame() {
        return frame;
    }

    @Override
    public void complete() {
        Frame preFrame = analyzerContext.enter(this);
        frame = analyzerContext.currentFrame();
        try {
            super.complete(false);
        } finally {
            frame.lock();
            analyzerContext.exitTo(preFrame);
        }
        if (thenContext != null) {
            thenContext.complete();
        }
    }
}
