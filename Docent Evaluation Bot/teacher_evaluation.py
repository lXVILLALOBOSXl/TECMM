from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import ElementClickInterceptedException, NoSuchElementException, TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from time import sleep

class EvaluationBot:

    def __init__(self):
        chrome_options = webdriver.ChromeOptions()
        chrome_options.add_experimental_option("detach", True)
        self.driver = webdriver.Chrome(options=chrome_options)

    def qualify(self,user:str,password:str, qualifications:list):
        #Load evaluation webpage
        self.driver.get("http://evaluacion.tecmm.mx:8092/sed/index.php")
        sleep(3)
        self.driver.switch_to.frame("mainFrame")

        #Get Log in form
        students_button = self.driver.find_element(by=By.XPATH,value='//*[@id="img_alumnos"]')
        students_button.click()
        sleep(2)
        
        #Log in on student account
        username_field = self.driver.find_element(by=By.XPATH,value='//*[@id="tabla_acceso"]/table/tbody/tr[3]/td/input')
        username_field.send_keys(user)
        sleep(2)

        password_field = self.driver.find_element(by=By.XPATH,value='//*[@id="tabla_acceso"]/table/tbody/tr[4]/td/input')
        password_field.send_keys(password)
        sleep(2)

        sign_in_button = self.driver.find_element(by=By.XPATH,value='//*[@id="tabla_acceso"]/div/input')
        sign_in_button.click()
        sleep(2)

        #Choose evaluation option
        self.driver.switch_to.default_content() 
        self.driver.switch_to.frame("topFrame") 
        evaluation_button = self.driver.find_element(by=By.XPATH,value='/html/body/div[2]')
        evaluation_button.click()
        sleep(2)

        self.driver.switch_to.default_content() 
        self.driver.switch_to.frame("mainFrame") 
        # detachable list option
        evaluation_option = self.driver.find_element(by=By.XPATH,value='/html/body/div/div[1]')
        evaluation_option.click()

        continue_button = self.driver.find_element(by=By.XPATH,value='/html/body/form/div/input[1]')
        continue_button.click()
        sleep(2)

        #Evaluate teachers
        self.driver.switch_to.default_content()
        self.driver.switch_to.frame("mainFrame")
        
        next_question = self.driver.find_element(by=By.XPATH,value='//*[@id="cuestionario"]/center/input');
        while next_question:
            rows = self.driver.find_elements(By.XPATH, '//*[@id="cuestionario"]/table/tbody/tr')

            for i, qualification in enumerate(qualifications):
                radio_button = rows[i].find_element(By.XPATH, f'./td[input[@value="{qualification}"]]/input')
                radio_button.click()
                sleep(0.5)

            next_question.click()
            sleep(2)
            try:
                next_question = self.driver.find_element(by=By.XPATH,value='//*[@id="cuestionario"]/center/input');
            except NoSuchElementException:
                break
        
        print("Evaluation completed successfully")


    

            

        

