import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
import numpy as np
height = np.random.normal(170,10,10)
weight = np.random.normal(70,5,10)

df = pd.DataFrame({'height':height,'weight':weight})

x = df['height']
y = df['weight']

x_train , x_test,y_train,y_test = train_test_split(x,y,test_size=0.25,random_state=42)

linear = LinearRegression()
linear.fit(x_train.values.reshape(-1,1),y_train)

print("Coeficient :",linear.coef_)

y_pred = linear.predict(x_test.values.reshape(-1,1))
print(y_pred)