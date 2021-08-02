
pipeline {
    agent any

    stages {

        stage("Reporting which branch is the build on") {
            steps {
                echo BRANCH_NAME
            }
        }

        stage("Browser input for testing")
        {
            steps {
                script{
                    env.BROWSER_INPUT = input message: 'Enter a name browser that you want to use for testing' , parameters: [
                    string(defaultValue: '', description: 'browser used for tests', name: 'browserInput')]

                    if (env.BROWSER_INPUT == 'chrome'){
                        sh 'mvn clean test'
                    }
                    else if (env.BROWSER_INPUT == 'firefox') {
                        sh 'mvn clean test -Dbrowser=firefox'
                    }
                }

                echo "Browser used: ${env.BROWSER_INPUT}"
            }
        }

        //stage("Chrome Testing") {

            //steps {
                //script {
                    //CHROME_TEST = sh( script: "mvn clean test", returnStdout: true).trim()
                //}
                //echo "${CHROME_TEST}"
            //}
        //}

        //stage("Firefox Testing") {

              //steps {
                   //script {
                        //FIREFOX_TEST = sh( script: "mvn clean test -Dbrowser=firefox", returnStdout: true).trim()
                   //}
                   //echo "${FIREFOX_TEST}"
                       // if()
                      //  sh 'mvn clean test -Dbrowser=firefox'
                    //}
                //}






    }
    post {
        always {
            echo 'ALWAYS COMPLETING'
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }


    }



}