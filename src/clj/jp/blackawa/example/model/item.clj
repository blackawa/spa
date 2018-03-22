(ns jp.blackawa.example.model.item)

(defn find-by-category [_]
  [{:title "item1" :uri "/items/1" :image-url "http://via.placeholder.com/300x300" :price 100}
   {:title "item2" :uri "/items/2" :image-url "http://via.placeholder.com/300x300" :price 200}
   {:title "item3" :uri "/items/3" :image-url "http://via.placeholder.com/300x300" :price 300}
   {:title "item4" :uri "/items/4" :image-url "http://via.placeholder.com/300x300" :price 400}
   {:title "item5" :uri "/items/5" :image-url "http://via.placeholder.com/300x300" :price 500}
   {:title "item6" :uri "/items/6" :image-url "http://via.placeholder.com/300x300" :price 600}
   {:title "item7" :uri "/items/7" :image-url "http://via.placeholder.com/300x300" :price 700}
   {:title "item8" :uri "/items/8" :image-url "http://via.placeholder.com/300x300" :price 800}
   {:title "item9" :uri "/items/9" :image-url "http://via.placeholder.com/300x300" :price 900}
   {:title "item10" :uri "/items/10" :image-url "http://via.placeholder.com/300x300" :price 1000}
   {:title "item11" :uri "/items/11" :image-url "http://via.placeholder.com/300x300" :price 1100}
   {:title "item12" :uri "/items/12" :image-url "http://via.placeholder.com/300x300" :price 1200}
   {:title "item13" :uri "/items/13" :image-url "http://via.placeholder.com/300x300" :price 1300}
   {:title "item14" :uri "/items/14" :image-url "http://via.placeholder.com/300x300" :price 1400}
   {:title "item15" :uri "/items/15" :image-url "http://via.placeholder.com/300x300" :price 1500}])

(defn find-by-id [id]
  {:title (format "item%s" id)
   :uri (format "/items/%s" id)
   :image-url "http://via.placeholder.com/300x300"
   :price (format "%s00" id)
   :description (condp = (rem id 3)
                  0 "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque laoreet efficitur turpis, at lobortis massa tempus ac. Pellentesque eros odio, congue a commodo ut, egestas ac quam. Fusce aliquet elementum feugiat. Pellentesque et orci et turpis eleifend iaculis in eget mauris. Aenean tincidunt viverra consequat. Donec dolor purus, consequat ac nulla feugiat, feugiat lacinia arcu. Suspendisse ut dictum risus, eget porta odio. Sed vitae nisl id nisi facilisis ullamcorper at in justo. Vestibulum ac molestie risus. Integer at orci ipsum. Donec tincidunt malesuada vehicula."
                  1 "Vivamus ac posuere odio. Aenean in elit id dolor pharetra malesuada. Praesent a ante mattis, molestie felis sed, pharetra urna. Aliquam pharetra erat tellus, vitae blandit nibh faucibus in. In et ex blandit, rutrum quam sit amet, rhoncus velit. Phasellus sit amet orci ac dolor laoreet ullamcorper sit amet vitae tortor. Nullam mattis arcu et erat eleifend, quis feugiat neque hendrerit."
                  2 "Integer et urna iaculis orci luctus posuere. Duis sit amet elit libero. Proin aliquet, orci eleifend iaculis ultrices, magna ex luctus dui, quis ultricies felis eros laoreet purus. Praesent tempus iaculis lorem, non commodo purus euismod eget. Curabitur volutpat ipsum ut urna tristique, nec mattis elit placerat. Suspendisse ac augue faucibus, lacinia neque a, ultrices diam. Praesent sit amet ante tempus, sodales mauris eget, laoreet est. Aenean sed eros eget elit vehicula imperdiet sed a enim. Maecenas tincidunt fringilla sem, nec feugiat arcu consequat a. Phasellus quis imperdiet lectus. Vestibulum nec pulvinar purus. Nunc auctor diam a auctor ultrices. Cras ultricies, purus sit amet lacinia luctus, mauris leo faucibus erat, et gravida est justo eu ex.")})
