from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori,association_rules
import pandas as pd

data=[
    ['bread','milk'],
    ['bread','diaper','beer','eggs'],
    ['diaper','bread','cake','milk'],
    ['diaper','milk','cake','bread'],
]

te = TransactionEncoder()

te_ar = te.fit(data).transform(data)
df = pd.DataFrame(te_ar,columns=te.columns_)
# print(df)

freq_item = apriori(df,min_support=0.05,use_colnames=True)
print(freq_item)

rules = association_rules(freq_item,metric='support',min_threshold=0.05)

rules = rules.sort_values(['support','confidence'],ascending=[False,False])
print(rules)