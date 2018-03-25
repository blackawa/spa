;; clientの初期化スクリプトでこれをやると
;; クライアントサイドルーティングができるはず？
(accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (dispatch :view (match-route route path)))
    :path-exists?
    (fn [path]
      (some? (match-route route path)))})
(accountant/dispatch-current!)
