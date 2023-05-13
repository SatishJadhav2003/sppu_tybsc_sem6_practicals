import pandas as pd
import numpy as np
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
import matplotlib.pyplot as plt

np.random.seed(42)

user_id = range(1, 1001)
gender = np.random.choice(['Male', 'Female'], 1000)
age = np.random.randint(18, 65, 1000)
salary = np.random.randint(20000, 150001, 1000)
purchased = np.random.choice([0, 1], 1000, p=[0.6, 0.4])

df = pd.DataFrame({'User ID': user_id, 'Gender': gender, 'Age': age, 'Estimated Salary': salary, 'Purchased': purchased})
# print(df.head(100))
x = df.drop(['User ID', 'Purchased'], axis=1)
y= df['Purchased']

x_train,y_train,x_test,y_test = train_test_split(x,y,test_size=0.25,random_state=0)

logistic = LogisticRegression()
logistic.fit(x_train,y_train)

y_pred = logistic.predict(x_test)
print(y_pred)