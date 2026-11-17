(ns economics.wealth-distribution.accounted.u1-what-is-money)


(comment ()
         ;; We are Alice, and we want to buy a computer.
         (let [[tx & _ :as transactions] [{:from ["Liabilities" "US Government" "Finance Department"] :to ["Assets" "Cash"] :amount 10}
                                          {:from ["Liabilities" "Computer Store"] :to ["Assets" "Equipment" "Office Computer"] :amount 500}]
               initial-state             (interpose {:history [] :balance 0} (mapcat (juxt :to :from) transactions))]

           (reduce (fn [state {:keys [from to amount]}] (update-in state [from :balance] #(+ % amount))) initial-state transactions))


         ;; Simplest version
         {["Assets" "Cash"]                10
          ["Assets" "Equipment"]           500
          ["Liabilities" "US Government"]  -10
          ["Liabilities" "Computer Store"] -500
          }

         ;; Keeping a bit more context

         {["Assets" "Cash"] [...transactions]}





         {account1 {:history []
                    :balance 10000}})
