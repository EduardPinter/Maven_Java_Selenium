
pipeline {
    agent any

    stages {
        stage("build") {

            steps {
                script {
                    CHROME_TEST = sh( script: "mvn clean test", returnStdout: true).trim()
                }
                echo "${CHROME_TEST}"
               // if()
              //  sh 'mvn clean test -Dbrowser=firefox'
            }
        }

        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'maven'
                }
            }
            steps {
                echo 'TESTING THE APPLICATION'
            }
        }

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