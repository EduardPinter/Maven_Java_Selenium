
pipeline {
    agent any

    stages {

        stage("Checking if branch name is Maven") {
            when {
                expression {
                    env.BRANCH_NAME !== 'maven'
                }
            }
            steps {
                error("Branch name is not maven " + env.BRANCH_NAME)
            }
        }

        stage("Chrome Testing") {

            steps {
                script {
                    CHROME_TEST = sh( script: "mvn clean test", returnStdout: true).trim()
                }
                echo "${CHROME_TEST}"
               // if()
              //  sh 'mvn clean test -Dbrowser=firefox'
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