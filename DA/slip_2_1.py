import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression


df = pd.read_csv("salary.csv")
X = df.iloc[:,0:1]
y = df.iloc[:,1]

# Splitting data
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.25,random_state=15)

# performing simple regression

regressor = LinearRegression()
regressor.fit(X_train,y_train)

print("coefficients: ",regressor.coef_)
print("Entercept: ",regressor.intercept_)

plt.scatter(X_train,y_train,color='green')
plt.plot(X_train,regressor.predict(X_train),color='red',linewidth=3)
plt.show()

