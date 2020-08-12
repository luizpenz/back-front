FROM nginx
# Expor porta 80
EXPOSE 80
# Substrituir config nginx
ADD config/default.conf /etc/nginx/conf.d/
# Copia dist
ADD dist /usr/share/nginx/dist
