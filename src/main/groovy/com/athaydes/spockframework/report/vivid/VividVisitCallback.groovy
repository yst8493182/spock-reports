package com.athaydes.spockframework.report.vivid

import groovy.transform.CompileStatic
import org.codehaus.groovy.ast.MethodNode
import org.spockframework.util.Nullable

@CompileStatic
class VividVisitCallback {

    @Nullable
    SpecSourceCodeCollector codeCollector

    // temp storage for method currently being visited
    private final Queue<MethodNode> methodsVisits = [ ] as Queue

    void startClass( String className ) {
        if ( codeCollector == null ) {
            throw new NullPointerException( "codeCollector was not set" )
        }

        codeCollector.className = className
    }

    void onMethodEntry( MethodNode methodNode ) {
        methodsVisits.add( methodNode )
    }

    void onMethodExit() {
        methodsVisits.poll()
    }

}