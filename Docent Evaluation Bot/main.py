from time import sleep
from teacher_evaluation import EvaluationBot as eb

USERNAME = '220120139'
PASSWORD = '0139'
QUALIFICATIONS = [4,4,4,5,5,5]

def main():
    evaluation_bot = eb()
    evaluation_bot.qualify(USERNAME,PASSWORD,QUALIFICATIONS)


if __name__ == "__main__":
    main()