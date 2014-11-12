package br.com.fscan.test;

import br.com.fscan.annotations.FScanComponent;
import br.com.fscan.impl.FscanFilter;
import br.com.fscan.operation.FScan;

/**
 * Created with IntelliJ IDEA.
 *
 * @author renatomoitinhodias@gmail.com
 * @since 12/11/14 02:07
 */
public class Samples {




    public static void main(String[] args){

        // collections results
        FScan.findAll().all();
        FScan.findInterfaces().all();
        FScan.findClass().all();
        FScan.findEnum().all();
        FScan.findPackages();
        FScan.findAnnotation();


        FScan.findClass().filter(FscanFilter.annotationPresent(FScanComponent.class)).all();

        FScan.findPackages().inProject("fscan");
        FScan.findAll().in("br.com.fscan.test");
        FScan.findAnnotation().in("br.com.fscan.annotations");

        FScan.findInterfaces().filter(FscanFilter.contains("Action","Query")).in("br.com.fscan");


        //FScan.findClass().filter(FScanFilter.annotationPresent(a.class,b.class ...) )
        //FScan.findClass().filter(FScanFilter.contains("param") )

    }

}
